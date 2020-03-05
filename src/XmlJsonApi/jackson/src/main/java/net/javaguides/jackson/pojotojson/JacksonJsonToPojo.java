package net.javaguides.jackson.pojotojson;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Convert JSON to Java object using Jackson
 * @author Ramesh Fadatare
 * @author Marcel Pfahrer - replaced 'Set' property with an array
 */
public class JacksonJsonToPojo {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Read JSON file and convert to java object
        InputStream fileInputStream = new FileInputStream("post.json");
        Post post = mapper.readValue(fileInputStream, Post.class);
        fileInputStream.close();

        // print post object
        System.out.println("Printing post details");
        System.out.println(post.getId());
        System.out.println(post.getTitle());
        System.out.println(post.getDescription());
        System.out.println(post.getContent());
        System.out.println(post.getLastUpdatedAt());
        System.out.println(post.getPostedAt());

        // print tags of this post
        System.out.println("Printing tag details of post :: " + post.getTitle());
        for (int i=0; i<post.getTags().length; i++) {
            System.out.println(post.getTags()[i].getId());
            System.out.println(post.getTags()[i].getName());
        }
    }
}
