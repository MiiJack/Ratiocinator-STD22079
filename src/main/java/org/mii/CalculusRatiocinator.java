package org.mii;

import org.mii.affirmation.Affirmation;
import org.mii.conjonctions.Conjonction;

public class CalculusRatiocinator {
  public static String calculer(Affirmation affirmation) {
    if (affirmation.getConjonction() != null) {
      Conjonction conjonction = affirmation.getConjonction();
      String statusLeft = calculer(conjonction.getPremièreAffirmation());
      String statusRight = calculer(conjonction.getDeuxièmeAffirmation());

      return conjonction.evaluer(statusLeft, statusRight);
    } else {
      System.out.println(affirmation.getStatut());
      return affirmation.getStatut();
    }
  }
}
