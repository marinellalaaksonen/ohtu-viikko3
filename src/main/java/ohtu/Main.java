package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import javax.naming.ContextNotEmptyException;
import java.util.ArrayList;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String bodyText = Request.Get("https://studies.cs.helsinki.fi/courses/courseinfo").execute().returnContent().asString();

        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText );

        Gson mapper = new Gson();
        Course[] courses = mapper.fromJson(bodyText, Course[].class);
        HashMap<String, Course> kurssihaku = new HashMap<>();

        for (Course course : courses) {
            kurssihaku.put(course.name, course);
        }

        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";

        bodyText = Request.Get(url).execute().returnContent().asString();

        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText );

        mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        for (Submission submission : subs) {
            kurssihaku.get(submission.course).addSubmission(submission);
        }
        
        //System.out.println("Oliot:");
        System.out.println("Opiskelijanumero: " + studentNr);

        for (Course course : courses) {
            if (course.getSubmissions().size() == 0) {
                continue;
            }

            int tunnitYhteensa = 0;
            int tehtavatYhteensa = 0;

            System.out.println("\n" + course.fullName + "\n");

            for (Submission submission : course.getSubmissions()) {
                tunnitYhteensa += submission.hours;
                tehtavatYhteensa += submission.exercises.length;
                System.out.println("viikko " + submission.week + ":");
                System.out.println(" tehtyjä tehtäviä " + submission.exercises.length + "/" + course.exercises[submission.week] +
                        " aikaa kului " + submission.hours + " tehdyt tehtävät: " + submission.tehtavatStringina());
            }
            System.out.println("\nyhteensä: " + tehtavatYhteensa + "/" + course.tehtavatYhteensa() + " tehtävää " + tunnitYhteensa + " tuntia");
            course.tulostaStatistiikka();
        }

        //System.out.println("\nyhteensä: " + tehtavatYhteensa + " tehtävää " + tunnitYhteensa + " tuntia");


    }
}