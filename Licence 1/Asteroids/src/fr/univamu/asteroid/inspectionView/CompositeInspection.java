package fr.univamu.asteroid.inspectionView;

import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * DO NOT MODIFY THIS CLASS!
 */
public class CompositeInspection<T> implements Function<T,Inspection> {

  private final Function<T,String> formatter;
  private final List<Function<T,Inspection>> subInspections;

  public CompositeInspection(Function<T,String> formatter,
                             List<Function<T,Inspection>> subInspections)
  {
    this.formatter = formatter;
    this.subInspections = subInspections;
  }

  @Override
  public Inspection apply(T t) {
    return new Composition(t) {

    };
  }

  private class Composition extends Inspection {
    private final List<Inspection> inspections = new ArrayList<>();
    private final Supplier<String> format;

    public Composition(T t) {
      item = new TreeItem<>(formatter.apply(t));
      format = () -> formatter.apply(t);
      for (Function<T, Inspection> f : subInspections) {
        inspections.add(f.apply(t));
      }
      List<TreeItem<String>> subItems =
        inspections.stream()
          .map(Inspection::getItem)
          .collect(Collectors.toList());
      item.getChildren().addAll(subItems);
      item.setExpanded(true);
    }

    @Override
    public void update() {
      item.setValue(format.get());
      for (Inspection subInspection : inspections) {
        subInspection.update();
      }
    }

  }

}
