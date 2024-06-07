package org.mii.affirmation;

import lombok.Getter;
import org.mii.conjonctions.Conjonction;

@Getter
public sealed class Affirmation permits Verite, Mensonge {
  private final String phrase;
  private final String statut;
  private final Conjonction conjonction;

  public Affirmation(String phrase) {
    this.phrase = phrase;
    this.statut = "JENESAISPAS";
    this.conjonction = null;
  }

  public Affirmation(Conjonction conjonction) {
    this.phrase = conjonction.getPhrase();
    this.statut = conjonction.getStatut();
    this.conjonction = conjonction;
  }
}
