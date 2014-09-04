package fr.herman.criteria.core.predicate;

import java.util.Objects;
import fr.herman.criteria.core.Criterion;
import fr.herman.criteria.core.CriterionVisitor;
import fr.herman.criteria.core.criterion.objects.EqualCriterion;
import fr.herman.criteria.core.criterion.objects.SameCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.AndCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.NotCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.OrCriterion;
import fr.herman.criteria.core.criterion.objects.comparable.GreaterCriterion;
import fr.herman.criteria.core.criterion.objects.comparable.LesserCriterion;

public class PredicateCriterionVisitor<OBJECT> extends CriterionVisitor<Boolean, OBJECT>
{

    @Override
    public <T> Boolean visit(SameCriterion<T> criterion, OBJECT param)
    {
        PredicateParameterVisitor<T, OBJECT> visitor = new PredicateParameterVisitor<>();
        return criterion.getLeft().accept(visitor, null) == criterion.getRight().accept(visitor, param);
    }

    @Override
    public <T> Boolean visit(EqualCriterion<T> criterion, OBJECT param)
    {
        PredicateParameterVisitor<T, OBJECT> visitor = new PredicateParameterVisitor<>();
        return Objects.equals(criterion.getLeft().accept(visitor, null), criterion.getRight().accept(visitor, param));
    }

    @Override
    public Boolean visit(NotCriterion criterion, OBJECT param)
    {
        return !criterion.getSubCriterion().accept(this, param);
    }

    @Override
    public Boolean visit(AndCriterion criterion, OBJECT param)
    {
        for (Criterion<?> subCriterion : criterion.getList())
        {
            if (!subCriterion.accept(this, param))
            {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visit(OrCriterion criterion, OBJECT param)
    {
        for (Criterion<?> subCriterion : criterion.getList())
        {
            if (subCriterion.accept(this, param))
            {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public <T extends Comparable<T>> Boolean visit(LesserCriterion<T> criterion, OBJECT param)
    {
        PredicateParameterVisitor<T, OBJECT> visitor = new PredicateParameterVisitor<>();
        return compare(criterion.getLeft().accept(visitor, null), criterion.getRight().accept(visitor, param)) > 0;
    }

    @Override
    public <T extends Comparable<T>> Boolean visit(GreaterCriterion<T> criterion, OBJECT param)
    {
        PredicateParameterVisitor<T, OBJECT> visitor = new PredicateParameterVisitor<>();
        return compare(criterion.getLeft().accept(visitor, null), criterion.getRight().accept(visitor, param)) < 0;
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
