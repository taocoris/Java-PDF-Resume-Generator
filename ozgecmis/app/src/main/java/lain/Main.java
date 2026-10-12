package lain;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Experience> myExperiences = new ArrayList<>();
        myExperiences.add(new Experience("TechCorp Yazılım", "Backend Geliştirici", "2023 - Devam Ediyor", "Java ve Spring Boot kullanılarak mikroservis mimarilerinin tasarlanması ve geliştirilmesi."));
        myExperiences.add(new Experience("Gelecek AI Sistemleri", "Veri Analisti", "2021 - 2023", "Büyük veri setlerinin analizi ve makine öğrenimi modelleri için veri hazırlığı."));
        myExperiences.add(new Experience("StartUp Bilişim", "Stajyer Yazılım Mühendisi", "2020 - 2021", "C ve Java projelerinde hata ayıklama ve temel algoritma tasarımları."));

        ResumeGenerator generator = new ResumeGenerator("Taha_Topaloğlu_CV.pdf");
        
        generator.generateResume(
            "Taha Topaloğlu", 
            "eposta@mail.com", 
            "+90 523 345 67 89", 
            "profile.jpg", 
            myExperiences
        );
    }
} 