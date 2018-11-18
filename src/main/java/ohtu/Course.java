package ohtu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;
import java.io.IOException;

public class Course {
    public String fullName;
    public String name;
    public int[] exercises;
    private ArrayList<Submission> subs = new ArrayList<Submission>();

    public void addSubmission(Submission submission) {
        subs.add(submission);
    }

    public ArrayList<Submission> getSubmissions() {
        Collections.sort(subs);
        return subs;
    }

    public int tehtavatYhteensa() {
        int yhteensa = 0;
        for (int i = 0; i < exercises.length; i++) {
            yhteensa += exercises[i];
        }
        return yhteensa;
    }

    public void tulostaStatistiikka() throws IOException {
        String url = "https://studies.cs.helsinki.fi/courses/" + this.name + "/stats"; // palvelimelta haettu opiskelijoiden palautusstatistiikka
        String statsResponse = Request.Get(url).execute().returnContent().asString();

        JsonParser parser = new JsonParser();
        JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();

        int palautukset = 0;
        int tehtavia = 0;
        int tunnit = 0;

        for (String avain : parsittuData.keySet()) {
            //System.out.println(parsittuData.get(avain).getAsJsonObject());
            palautukset += parsittuData.get(avain).getAsJsonObject().get("students").getAsInt();
            tunnit += parsittuData.get(avain).getAsJsonObject().get("hour_total").getAsInt();
            tehtavia += parsittuData.get(avain).getAsJsonObject().get("exercise_total").getAsInt();
        }

        System.out.println("\nkurssilla yhteensä " + palautukset + " palautusta, palautettuja tehtäviä " + tehtavia 
                + " kpl, aikaa käytetty yhteensä " + tunnit + " tuntia");
        }

    @Override
    public String toString() {
        return name;
    }
}