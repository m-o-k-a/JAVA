package fr.univamu.asteroid.inspectionView;

import javafx.scene.control.TreeItem;

import java.util.function.Function;

/**
 * DO NOT MODIFY THIS CLASS!
 */
public class FieldInspection<T,S> implements Function<T,Inspection> {

  private final Function<S,Inspection> inspectionFactory;
  private final Function<T,S> fieldGetter;

  public FieldInspection(Function<S, Inspection> inspectionFactory,
                         Function<T,S> fieldGetter)
  {
    this.fieldGetter = fieldGetter;
    this.inspectionFactory = inspectionFactory;
  }

  @Override
  public Inspection apply(T t) {
    return new InspectField(t);
  }


  private class InspectField extends Inspection {

    private final T owner;
    private S inspected;
    private Inspection inspection;

    public InspectField(T t) {
      owner = t;
      initialize();
    }

    private void initialize() {
      this.inspected = fieldGetter.apply(owner);
      this.inspection = inspectionFactory.apply(inspected);
      item = inspection.getItem();
    }

    @Override
    public void update() {
      if (fieldGetter.apply(owner) == inspected) {
        inspection.update();
      } else {
        reinitialize();
      }
    }

    private void reinitialize() {
      TreeItem<String> parent = item.getParent();
      int index = parent.getChildren().indexOf(item);
      initialize();
      parent.getChildren().set(index,item);
    }

  }
}
