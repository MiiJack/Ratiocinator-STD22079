package org.mii;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mii.affirmation.Affirmation;
import org.mii.affirmation.Mensonge;
import org.mii.affirmation.Verite;
import org.mii.conjonctions.Donc;
import org.mii.conjonctions.Et;
import org.mii.conjonctions.Ou;

class CalculusRatiocinatorTest {
  @Test
  void statutDeVéritéEstVrai() {
    Verite louEstBeau = new Verite("Lou est beau");
    assertEquals("VRAI", louEstBeau.getStatut());
  }

  @Test
  void statutDeMensongeEstFaux() {
    Mensonge louEstPauvre = new Mensonge("Lou est pauvre");
    assertEquals("FAUX", louEstPauvre.getStatut());
  }

  @Test
  void statutDAffirmationEstJeNeSaisPasParDefaut() {
    Affirmation louEstGénéreux = new Affirmation("Lou est généreux");
    assertEquals("JENESAISPAS", louEstGénéreux.getStatut());
  }

  @Test
  public void calculus_ratiocinator_autour_de_lou() {
    var verite1 = new Verite("Lou est beau");
    var mensonge1 = new Mensonge("Lou est pauvre");
    var affirmation1 = new Affirmation("Lou est généreux");

    var louEstPauvreEtLouEstGenereux = new Affirmation(new Et(mensonge1, affirmation1));
    assertEquals("FAUX", CalculusRatiocinator.calculer(louEstPauvreEtLouEstGenereux));

    var louEstBeauDoncLouEstPauvre = new Affirmation(new Donc(verite1, mensonge1));
    assertEquals("FAUX", CalculusRatiocinator.calculer(louEstBeauDoncLouEstPauvre));

    var louEstPauvreDoncLouEstGenereux = new Affirmation(new Donc(mensonge1, affirmation1));
    assertEquals("VRAI", CalculusRatiocinator.calculer(louEstPauvreDoncLouEstGenereux));

    var louEstBeauOuLouEstGenereux = new Affirmation(new Ou(verite1, affirmation1));
    var louEstBeauOuLouEstGenereuxDoncLouEstPauvre =
        new Affirmation(new Donc(louEstBeauOuLouEstGenereux, mensonge1));
    assertEquals(
        "FAUX", CalculusRatiocinator.calculer(louEstBeauOuLouEstGenereuxDoncLouEstPauvre));

    var louEstPauvreOuLouEstGenereux = new Affirmation(new Ou(mensonge1, affirmation1));
    var louEstBeauOuLouEstGenereuxDoncLouEstPauvreEtLouEstPauvreOuLouEstGenereux =
        new Affirmation(
            new Et(louEstBeauOuLouEstGenereuxDoncLouEstPauvre, louEstPauvreOuLouEstGenereux));
    assertEquals(
        "FAUX",
        CalculusRatiocinator.calculer(
            louEstBeauOuLouEstGenereuxDoncLouEstPauvreEtLouEstPauvreOuLouEstGenereux));
  }
}
