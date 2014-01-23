package com;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

@PersistenceCapable
public class NewsItem {
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Key key;
  
  private String title;
  
  private String link;
  
  private Text description;

  /**
   * @return the key
   */
  public Key getKey() {
    return key;
  }

  /**
   * @param key the key to set
   */
  public void setKey(Key key) {
    this.key = key;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the link
   */
  public String getLink() {
    return link;
  }

  /**
   * @param link the link to set
   */
  public void setLink(String link) {
    this.link = link;
  }

  /**
   * @return the description
   */
  public Text getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(Text description) {
    this.description = description;
  }
  
}
