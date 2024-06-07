package org.mii.conjonctions;

import org.mii.affirmations.StatutAffirmation;

public abstract sealed class Conjonction permits Et, Ou, Donc {
  public final String valeur;

  protected Conjonction(String valeur) {
    this.valeur = valeur;
  }

  public abstract StatutAffirmation evaluer(
      StatutAffirmation statutAffirmation1, StatutAffirmation statutAffirmation2);
}
