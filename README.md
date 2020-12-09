# OrderedArrayList

Questions we had:
- How are `NoNullArrayList` constructors different from those of `ArrayList`?
- What does this mean --> `The serializable class NoNullArrayList does not declare a static final serialVersionUID field of type long`?

Things we discussed:
- We can perform the sorting by using the comparison methods that everything
`Comparable` has, which allows us to put the new elements into the correct
position.
