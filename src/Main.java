import java.io.*;
import java.nio.file.Files;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String imagePath = "photo.jpg"; // Change to your image path
        String vcfPath = "contact.vcf";

        try {
            // Read image and encode to Base64
            byte[] imageBytes = Files.readAllBytes(new File(imagePath).toPath());
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);

            String vCard = "BEGIN:VCARD\n" +
                    "VERSION:3.0\n" +
                    "FN:Nina Nikolova\n" +
                    "ORG:Sofia University St. Kliment Ohridski\n" +
                    "TITLE:Master\\'s Student in Software Technologies\n"+
                    "TEL;TYPE=mobile:+359884127067\n" +
                    "EMAIL:ninahn@uni-sofia.bg\n" +
                    "URL;WORK:https://personal-portfolio-hazel-six.vercel.app\n"+
                    "PHOTO;ENCODING=b;TYPE=JPEG:" + base64Image + "\n" +
                    "END:VCARD";


            // Write to .vcf file
            FileWriter writer = new FileWriter(vcfPath);
            writer.write(vCard);
            writer.close();

            System.out.println("vCard generated: " + vcfPath);
        } catch (IOException e) {
            System.err.println("🔍 Debug Info: " + e.getMessage());
        }
    }
}