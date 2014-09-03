package fr.herman.criteria.predicate;

import java.util.Objects;
import fr.herman.criteria.CriterionVisitor;
import fr.herman.criteria.criterion.objects.EqualCriterion;
import fr.herman.criteria.criterion.objects.SameCriterion;
import fr.herman.criteria.criterion.objects.booleans.AndCriterion;
import fr.herman.criteria.criterion.objects.booleans.NotCriterion;
import fr.herman.criteria.criterion.objects.booleans.OrCriterion;
import fr.herman.criteria.criterion.objects.comparable.GreaterCriterion;
import fr.herman.criteria.criterion.objects.comparable.LesserCriterion;

public class PredicateCriterionVisitor extends CriterionVisitor<Boolean, Void>
{


    @Override
    public <T> Boolean visit(SameCriterion<T> criterion, Void param)
    {
        PredicateParameterVisitor<T> visitor = new PredicateParameterVisitor<>();
        return criterion.getLeft().accept(visitor, null) == criterion.getRight().accept(visitor, null);
    }

    @Override
    public <T> Boolean visit(EqualCriterion<T> criterion, Void param)
    {
        PredicateParameterVisitor<T> visitor = new PredicateParameterVisitor<>();
        return Objects.equals(criterion.getLeft().accept(visitor, null), criterion.getRight().accept(visitor, null));
    }

    @Override
    public Boolean visit(NotCriterion criterion, Void param)
    {
        return null;
    }

    @Override
    public Boolean visit(AndCriterion criterion, Void param)
    {
        return null;
    }

    @Override
    public Boolean visit(OrCriterion criterion, Void param)
    {
        return null;
    }

    @Override
    public <T extends Comparable<T>> Boolean visit(LesserCriterion<T> criterion, Void param)
    {
        PredicateParameterVisitor<T> visitor = new PredicateParameterVisitor<>();
        return compare(criterion.getLeft().accept(visitor, null), criterion.getRight().accept(visitor, null)) > 0;
    }

    @Override
    public <T extends Comparable<T>> Boolean visit(GreaterCriterion<T> criterion, Void param)
    {
        PredicateParameterVisitor<T> visitor = new PredicateParameterVisitor<>();
        return compare(criterion.getLeft().accept(visitor, null), criterion.getRight().accept(visitor, null)) < 0;
    }

    private static <T extends Comparable<T>> int compare(T a, T b)
    {
        if (a != null)
        {
            return a.compareTo(b);
        }
        return b != null ? -b.compareTo(a) : 0;
    }
}
