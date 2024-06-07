package org.mii.affirmation;

public final class Verite extends Affirmation {
  public Verite(String phrase) {
    super(phrase);
  }

  @Override
  public String getStatut() {
    return "VRAI";
  }
}
