package org.mii;

import org.mii.affirmations.Affirmation;

public class CalculusRatiocinator {
  public static Resultat calculer(Affirmation affirmation) {
    switch (affirmation.statutAffirmation()) {
      case MENSONGE -> {
        return Resultat.FAUX;
      }
      case VERITE -> {
        return Resultat.VRAI;
      }
      default -> {
        return Resultat.JENESAISPAS;
      }
    }
  }
}
