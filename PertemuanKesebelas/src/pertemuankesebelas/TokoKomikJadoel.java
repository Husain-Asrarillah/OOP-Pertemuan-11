/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankesebelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Husain
 */
@Entity
@Table(name = "toko_komik_jadoel")
@NamedQueries({
    @NamedQuery(name = "TokoKomikJadoel.findAll", query = "SELECT t FROM TokoKomikJadoel t"),
    @NamedQuery(name = "TokoKomikJadoel.findById", query = "SELECT t FROM TokoKomikJadoel t WHERE t.id = :id"),
    @NamedQuery(name = "TokoKomikJadoel.findByJudul", query = "SELECT t FROM TokoKomikJadoel t WHERE t.judul = :judul"),
    @NamedQuery(name = "TokoKomikJadoel.findByPengarang", query = "SELECT t FROM TokoKomikJadoel t WHERE t.pengarang = :pengarang"),
    @NamedQuery(name = "TokoKomikJadoel.findByTahun", query = "SELECT t FROM TokoKomikJadoel t WHERE t.tahun = :tahun"),
    @NamedQuery(name = "TokoKomikJadoel.findByGenre", query = "SELECT t FROM TokoKomikJadoel t WHERE t.genre = :genre")})
public class TokoKomikJadoel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "judul")
    private String judul;
    @Column(name = "pengarang")
    private String pengarang;
    @Column(name = "tahun")
    private Integer tahun;
    @Column(name = "genre")
    private String genre;

    public TokoKomikJadoel() {
    }

    public TokoKomikJadoel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TokoKomikJadoel)) {
            return false;
        }
        TokoKomikJadoel other = (TokoKomikJadoel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pertemuankesebelas.TokoKomikJadoel[ id=" + id + " ]";
    }
    
}
