package com.labticket.bean;

import java.util.ArrayList;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
 
import com.labticket.bean.Theme;
 
@ManagedBean(name="themeService", eager = true)
@ApplicationScoped
public class ThemeService {
     
    private List<Theme> themes;
     
    @PostConstruct
    public void init() {
        themes = new ArrayList<Theme>();
        themes.add(new Theme(0, "Emre Ova", "Emre Ova"));
        themes.add(new Theme(1, "Engin Bilen", "Engin Bilen"));
        themes.add(new Theme(2, "Harun Caliskan", "Harun Caliskan"));
        themes.add(new Theme(3, "Senem Gultekin", "Senem Gultekin"));
        themes.add(new Theme(4, "İsmail Kaya", "İsmail Kaya"));
        themes.add(new Theme(5, "Tugkan Ince", "Tugkan Ince"));
        themes.add(new Theme(6, "Burak Biyik", "Burak Biyik"));
        themes.add(new Theme(7, "Cigdem Vural", "Cigdem Vural"));
        themes.add(new Theme(8, "Yunus Ozturk", "Yunus Ozturk"));
        themes.add(new Theme(9, "Can Cinar", "Can Cinar"));
        themes.add(new Theme(10, "Cansu Kaya", "Cansu Kaya"));
        themes.add(new Theme(11, "Gurtac Kadem", "Gurtac Kadem"));
        themes.add(new Theme(12, "Utku Ozmat", "Utku Ozmat"));
        themes.add(new Theme(13, "Fatih Cakir", "Fatih Cakir"));
        
    
    }
     
    public List<Theme> getThemes() {
        return themes;
    } 
}