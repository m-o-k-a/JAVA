package fr.univamu.asteroid.inspectionView;

import javafx.scene.control.TreeItem;

import java.util.*;
import java.util.function.Function;

/**
 * DO NOT MODIFY THIS CLASS!
 */
public class ListInspection<T> implements Function<List<T>, Inspection> {


  private final Function<T,Inspection> inspectionFactory;
  private final Function<List<T>, String> formatter;

  public ListInspection(Function<List<T>, String> formatter,
                        Function<T, Inspection> inspectionFactory)
  {
    this.inspectionFactory = inspectionFactory;
    this.formatter = formatter;
  }

  @Override
  public Inspection apply(List<T> ts) {
    return new ListInspect(ts);
  }



  private class ListInspect extends Inspection {

    private final List<T> values;
    private final Map<T,Inspection> inspections = new HashMap<>();

    public ListInspect(List<T> values) {
      this.item = new TreeItem<>(formatter.apply(values));
      this.values = values;
    }


    public void update() {
      item.setValue(formatter.apply(values));
      Set<T> seen = new HashSet<>();
      for(T value : values) {
        updateValue(value);
        seen.add(value);
      }
      removeUnseen(seen);
    }


    private void removeUnseen(Set<T> seen) {
      List<Map.Entry<T,Inspection>> entriesToRemove = new ArrayList<>();
      for (Map.Entry<T,Inspection> entry : inspections.entrySet()) {
        if (!seen.contains(entry.getKey())) {
          entriesToRemove.add(entry);
        }
      }
      entriesToRemove.forEach(this::remove);
    }


    private void remove(Map.Entry<T, Inspection> entry) {
      inspections.remove(entry.getKey());
      TreeItem<String> item = entry.getValue().getItem();
      item.getParent().getChildren().remove(item);
    }


    private void updateValue(T value) {
      if (inspections.containsKey(value)) {
        inspections.get(value).update();
        return;
      }
      createValue(value);
    }

    private void createValue(T value) {
      Inspection inspection = inspectionFactory.apply(value);
      inspections.put(value,inspection);
      inspection.update();
      item.getChildren().add(inspection.getItem());
    }

  }
}
