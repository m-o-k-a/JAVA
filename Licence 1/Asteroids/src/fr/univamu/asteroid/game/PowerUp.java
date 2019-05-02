package fr.univamu.asteroid.game;

import fr.univamu.asteroid.tools.Vector;

public class PowerUp {
    public static int bonusScore = 500;
    public final int typeBonus;
    public final Vector position;

    public PowerUp(int typeBonus, Vector position) {
        this.typeBonus = typeBonus;
        this.position = position;
    }

    public int getBonusScore() { return bonusScore; }
    public Vector getPosition() { return position; }

    public void update() {
    }
}


/**
 Assurez-vous des points suivants :
 — dès qu’un astéroïde se fragmente, un bonus apparaît à l’endroit où se trouvait l’astéroïde.
 — le bonus est immobile.
 — si le vaisseau spatial est suffisamment proche du bonus, le bonus se déclenche.
 — le bonus modifie l’état du jeu, donc de l’espace. Il possède donc une méthode trigger prenant en paramètre l’état
 du jeu.
 — le bonus disparait au bout de quelques secondes s’il n’est pas pris.
 — le bonus est affiché sous la forme d’une étoile, dont la couleur dépendra de la nature du bonus (pour l’instant, une
 seule couleur car un seul type de bonus).
**/