package vmemo.model;

import javax.persistence.*;

@Entity
@Table(name = "Event")
@NamedQueries({
        @NamedQuery(name = "Event.findAll", query = "SELECT s FROM Event s"),
        @NamedQuery(name = "Event.findById", query = "SELECT s FROM Event s WHERE s.id = :id")})
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID")
    public long id;

    @Column(name = "title")
    public String title;
    @Column(name = "description")
    public String description;
}
