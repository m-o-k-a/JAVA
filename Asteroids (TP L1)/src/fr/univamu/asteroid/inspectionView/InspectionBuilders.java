package fr.univamu.asteroid.inspectionView;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * DO NOT MODIFY THIS CLASS!
 */
public class InspectionBuilders {

  public static <T> Function<T,Inspection> properties(
    String label,
    Function<T,Inspection>... inspections)
  {
    return new CompositeInspection<T>(
      constantFormatter(label),
      Arrays.asList(inspections)
    );
  }

  public static <T> Function<List<T>,Inspection> list(
    String label,
    Function<T,Inspection> inspection
  )
  {
    return new ListInspection<T>(
      constantFormatter(label),
      inspection
    );
  }

  public static <T,S> Function<T,Inspection> property(
    Function<T,S> getter,
    Function<S,Inspection> inspection)
  {
    return new FieldInspection<>(inspection,getter);
  }


  public static <T,S> Function<T,Inspection>
    labelledProperty(Function<T,S> getter, String label)
  {
    return property(getter, labelled(label));
  }

  public static <T,S> Function<T,Inspection>
    formattedProperty(Function<T,S> getter, Function<S,String> formatter)
  {
    return property(getter, formatted(formatter));
  }


  public static <T> Function<T,Inspection> labelled(String label) {
    return new BasicInspection<T>(value -> label + " : " + value);
  }

  public static <T> Function<T,Inspection> formatted(
    Function<T,String> formatter
  )
  {
    return new BasicInspection<T>(formatter);
  }


  private static <T> Function<T,String> constantFormatter(String cst) {
    return value -> cst;
  }
}
