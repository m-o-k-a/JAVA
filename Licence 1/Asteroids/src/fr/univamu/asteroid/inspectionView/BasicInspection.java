package fr.univamu.asteroid.inspectionView;

import javafx.scene.control.TreeItem;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * DO NOT MODIFY THIS CLASS!
 */
public class BasicInspection<T> implements Function<T, Inspection> {

  private final Function<T,String> formatter;

  public BasicInspection(Function<T,String> formatter) {
    this.formatter = formatter;
  }

  public Inspection apply(T t) {
    return new Basic(() -> formatter.apply(t));

  }

  private class Basic extends Inspection {

    private final Supplier<String> format;

    public Basic(Supplier<String> format) {
      this.format = format;
      item = new TreeItem<>(format.get());
    }

    @Override
    public void update() {
      item.setValue(format.get());
    }

  }
}
