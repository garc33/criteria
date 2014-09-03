package fr.herman.criteria;


public interface Criterion<T> extends Expression<T>
{
    <RESULT, PARAM> RESULT accept(CriterionVisitor<RESULT, PARAM> visitor, PARAM param);
}
