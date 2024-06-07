package org.mii;

import org.junit.jupiter.api.Test;
import org.mii.affirmations.Affirmation;
import org.mii.conjonctions.Donc;
import org.mii.conjonctions.Et;
import org.mii.conjonctions.Ou;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mii.Resultat.FAUX;
import static org.mii.Resultat.VRAI;
import static org.mii.affirmations.StatutAffirmation.*;

class CalculusRatiocinatorTest {
  @Test
  public void calculus_ratiocinator_autour_de_lou() {
    var verite1 = new Affirmation("Lou est beau", VERITE);
    var mensonge1 = new Affirmation("Lou est pauvre", MENSONGE);
    var affirmation1 = new Affirmation("Lou est généreux", AFFIRMATION);

    var louEstPauvreEtLouEstGenereux = mensonge1.joindre(new Et(), affirmation1);
    assertEquals(CalculusRatiocinator.calculer(louEstPauvreEtLouEstGenereux), FAUX);

    var louEstBeauDoncLouEstPauvre = verite1.joindre(new Donc(), mensonge1);
    assertEquals(CalculusRatiocinator.calculer(louEstBeauDoncLouEstPauvre), FAUX);

    var louEstPauvreDoncLouEstGenereux = mensonge1.joindre(new Donc(), affirmation1);
    assertEquals(CalculusRatiocinator.calculer(louEstPauvreDoncLouEstGenereux), VRAI);

    var louEstBeauOuLouEstGenereuxDoncLouEstPauvre = verite1.joindre(new Ou(), affirmation1).joindre(new Donc(), mensonge1);
    assertEquals(CalculusRatiocinator.calculer(louEstBeauOuLouEstGenereuxDoncLouEstPauvre), FAUX);

    var louEstPauvreOuLouEstGenereux = mensonge1.joindre(new Ou(), affirmation1);
    var louEstBeauOuLouEstGenereuxDoncLouEstPauvreEtLouEstPauvreOuLouEstGenereux = louEstBeauOuLouEstGenereuxDoncLouEstPauvre.joindre(new Et(), louEstPauvreOuLouEstGenereux);
    assertEquals(CalculusRatiocinator.calculer(louEstBeauOuLouEstGenereuxDoncLouEstPauvreEtLouEstPauvreOuLouEstGenereux), FAUX);
  }
  }