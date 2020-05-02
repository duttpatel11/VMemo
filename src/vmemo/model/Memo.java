/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Dutt2
 */
@Entity
@Table(name = "Memo")
@NamedQueries({
        @NamedQuery(name = "Memo.findAll", query = "SELECT s FROM Memo s"),
        @NamedQuery(name = "Memo.findById", query = "SELECT s FROM Memo s WHERE s.id = :id")})
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID")
    public long id;

    @Column(name = "title")
    public String title;

    @Column(name = "imageDescription")
    public String imageDescription;

    @Column(name = "imageUrl")
    public String imageUrl;

    @Column(name = "description")
    public String description;

    @Column(name = "recordingUrl")
    public String recordingUrl;

    @Override
    public String toString() {
        return "Memo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageDescription='" + imageDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", recordingUrl='" + recordingUrl + '\'' +
                '}';
    }
}

