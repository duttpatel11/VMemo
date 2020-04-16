/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classmodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Dutt2
 */
@Entity
@Table(name = "Player")
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findByPlayerNumber", query = "SELECT p FROM Player p WHERE p.playerNumber = :playerNumber"),
    @NamedQuery(name = "Player.findByPlayerName", query = "SELECT p FROM Player p WHERE p.playerName = :playerName")})
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PlayerNumber")
    private Long playerNumber;
    @Column(name = "PlayerName")
    private String playerName;

    public Player() {
    }

    public Player(Long playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Long getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Long playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerNumber != null ? playerNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.playerNumber == null && other.playerNumber != null) || (this.playerNumber != null && !this.playerNumber.equals(other.playerNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.classmodel.Player[ playerNumber=" + playerNumber + " ]";
    }
    
}
