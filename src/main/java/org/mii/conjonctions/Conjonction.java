package org.mii.conjonctions;

import lombok.Getter;
import org.mii.affirmation.Affirmation;

@Getter
public abstract sealed class Conjonction permits Et, Ou, Donc {
  protected final String valeur;
  protected final Affirmation premièreAffirmation;
  protected final Affirmation deuxièmeAffirmation;
  protected final String statut;
  protected final String phrase;

  protected Conjonction(
      String valeur, Affirmation premièreAffirmation, Affirmation deuxièmeAffirmation) {
    this.valeur = valeur;
    this.premièreAffirmation = premièreAffirmation;
    this.deuxièmeAffirmation = deuxièmeAffirmation;
    this.statut = "JENESAISPAS";
    this.phrase = "";
  }

  public abstract String evaluer(String statutAffirmation1, String statutAffirmation2);
}
