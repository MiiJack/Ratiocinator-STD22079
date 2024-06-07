package org.mii.conjonctions;

import static org.mii.affirmations.StatutAffirmation.*;

import org.mii.affirmations.StatutAffirmation;

public final class Donc extends Conjonction {
  public Donc() {
    super(" donc ");
  }

  @Override
  public StatutAffirmation evaluer(
      StatutAffirmation statutAffirmation1, StatutAffirmation statutAffirmation2) {
    if (statutAffirmation1.equals(VERITE) && statutAffirmation2.equals(MENSONGE)) {
      return MENSONGE;
    } else if (statutAffirmation1.equals(VERITE) && statutAffirmation2.equals(AFFIRMATION)) {
      return AFFIRMATION;
    }
    return VERITE;
  }
}
