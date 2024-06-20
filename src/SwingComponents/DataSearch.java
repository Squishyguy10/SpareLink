/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SwingComponents;

/**
 *
 * @author aviare
 */
public class DataSearch {

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the story
     */
    public boolean isStory() {
        return story;
    }

    /**
     * @param story the store to set
     */
    public void setStory(boolean story) {
        this.story = story;
    }
    
    public DataSearch(String t, boolean s){
        text = t;
        story = s;
    }
    public DataSearch(){
    }
    private String text;
    private boolean story;
}
