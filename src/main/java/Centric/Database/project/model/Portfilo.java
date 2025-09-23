package Centric.Database.project.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Portfilo {

  @Id
 private  Long Id;


 @Column(nullable = false)
 private  String assetName ;

 @Column(nullable = false)
 private  double  quantity ;


  private double price ;

}
