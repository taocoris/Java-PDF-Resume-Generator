package lain;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ResumeGenerator {
    
    private final String outputFilePath;

    public ResumeGenerator(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public void generateResume(String name, String email, String phone, String photoPath, List<Experience> experiences) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputFilePath));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.DARK_GRAY);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

            try {
                Image photo = Image.getInstance(photoPath);
                photo.scaleAbsolute(100f, 100f);
                photo.setAlignment(Element.ALIGN_RIGHT);
                document.add(photo);
            } catch (DocumentException | IOException e) {
                System.out.println("Fotoğraf bulunamadı veya eklenemedi, fotoğrafsız devam ediliyor.");
            }

            Paragraph namePara = new Paragraph(name, titleFont);
            document.add(namePara);
            
            Paragraph contactPara = new Paragraph("E-posta: " + email + " | Tel: " + phone, normalFont);
            contactPara.setSpacingAfter(20f);
            document.add(contactPara);

            Paragraph expTitle = new Paragraph("Is Deneyimleri", headerFont);
            expTitle.setSpacingAfter(10f);
            document.add(expTitle);

            for (Experience exp : experiences) {
                Paragraph jobTitle = new Paragraph(exp.getPosition() + " - " + exp.getCompanyName(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
                Paragraph jobDuration = new Paragraph(exp.getDuration(), FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 12));
                Paragraph jobDesc = new Paragraph(exp.getDescription(), normalFont);
                jobDesc.setSpacingAfter(15f);

                document.add(jobTitle);
                document.add(jobDuration);
                document.add(jobDesc);
            }

            document.close();
            System.out.println("Özgeçmiş başarıyla oluşturuldu: " + outputFilePath);

        } catch (DocumentException | IOException e) {
            System.err.println("PDF oluşturulurken bir hata meydana geldi: " + e.getMessage());
        }
    }
}