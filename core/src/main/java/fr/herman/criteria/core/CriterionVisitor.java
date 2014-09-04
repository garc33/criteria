package fr.herman.criteria.core;

import fr.herman.criteria.core.criterion.objects.EqualCriterion;
import fr.herman.criteria.core.criterion.objects.SameCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.AndCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.NotCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.OrCriterion;
import fr.herman.criteria.core.criterion.objects.comparable.GreaterCriterion;
import fr.herman.criteria.core.criterion.objects.comparable.LesserCriterion;

public abstract class CriterionVisitor<RESULT, PARAM>
{

    /** objects **/

    public abstract <T> RESULT visit(SameCriterion<T> criterion, PARAM param);

    public abstract <T> RESULT visit(EqualCriterion<T> criterion, PARAM param);

    /** booleans **/

    public abstract RESULT visit(NotCriterion criterion, PARAM param);

    public abstract RESULT visit(AndCriterion criterion, PARAM param);

    public abstract RESULT visit(OrCriterion criterion, PARAM param);

    /** comparable **/

    public abstract <T extends Comparable<T>> RESULT visit(LesserCriterion<T> criterion, PARAM param);

    public abstract <T extends Comparable<T>> RESULT visit(GreaterCriterion<T> criterion, PARAM param);

}
