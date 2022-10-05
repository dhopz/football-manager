package example;

import java.util.Comparator;

class FootballTableSortingComparator
    implements Comparator<Table> {

    @Override
    public int compare(Table table1,Table table2)
    {        
        int pointCompare = table1.getPoints().compareTo(
            table2.getPoints());

        int goalDiffCompare = table1.getGoalDifference().compareTo(
            table2.getGoalDifference()); 
        
        return (pointCompare == 0) ? goalDiffCompare : pointCompare;
    }
}