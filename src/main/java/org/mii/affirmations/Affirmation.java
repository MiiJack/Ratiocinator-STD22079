package org.mii.affirmations;

import org.mii.conjonctions.Conjonction;

public record Affirmation(String valeur, StatutAffirmation statutAffirmation) {
  public Affirmation joindre(Conjonction conjonction, Affirmation suiteAffirmation) {
    String nouvelleValeur = valeur + conjonction.valeur + suiteAffirmation.valeur();
    StatutAffirmation nouvelleStatusAffirmation =
        conjonction.evaluer(this.statutAffirmation(), suiteAffirmation.statutAffirmation());

    return new Affirmation(nouvelleValeur, nouvelleStatusAffirmation);
  }
}
