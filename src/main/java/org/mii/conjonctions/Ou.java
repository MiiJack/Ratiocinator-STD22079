package org.mii.conjonctions;

import org.mii.affirmation.Affirmation;

public final class Ou extends Conjonction {
  public Ou(Affirmation premièreAffirmation, Affirmation deuxièmeAffirmation) {
    super(" ou ", premièreAffirmation, deuxièmeAffirmation);
  }

  @Override
  public String evaluer(String statutAffirmation1, String statutAffirmation2) {
    if (statutAffirmation1.equals("VRAI") || statutAffirmation2.equals("VRAI")) {
      return "VRAI";
    } else if (statutAffirmation1.equals("FAUX") && statutAffirmation2.equals("FAUX")) {
      return "FAUX";
    } else {
      return "JENESAISPAS";
    }
  }
}
