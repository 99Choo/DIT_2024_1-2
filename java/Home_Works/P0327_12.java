package Home_Work;

abstract class PairMap {
  protected String keyArray[];    // 키를 저장하는 배열
  protected String valueArray[];  // 값을 저장하는 배열

  public PairMap(int size) {
      keyArray = new String[size];
      valueArray = new String[size];
  }

  // 키와 값을 저장하는 추상 메서드
  abstract public String get(String key);      // key 값을 가진 value를 반환, 없으면 null 반환
  abstract public void put(String key, String value); // key와 value를 쌍으로 저장
  abstract public String delete(String key);   // key 값을 가진 value를 삭제하고 그 값을 반환
  abstract public int length();                // 현재 저장된 쌍의 수 반환
}

class Dictionary1 extends PairMap {
  private int size; // 현재 저장된 쌍의 수

  public Dictionary1(int capacity) {
      super(capacity);
      size = 0;
  }

  @Override
  public String get(String key) {
      for (int i = 0; i < size; i++) {
          if (keyArray[i].equals(key)) {
              return valueArray[i]; // 해당 키에 대응하는 값 반환
          }
      }
      return null; // 키가 없으면 null 반환
  }

  @Override
  public void put(String key, String value) {
      for (int i = 0; i < size; i++) {
          if (keyArray[i].equals(key)) { // 키가 이미 존재하면 값을 갱신
              valueArray[i] = value;
              return;
          }
      }
      // 새로운 키-값 쌍을 추가
      if (size < keyArray.length) {
          keyArray[size] = key;
          valueArray[size] = value;
          size++;
      }
  }

  @Override
  public String delete(String key) {
      for (int i = 0; i < size; i++) {
          if (keyArray[i].equals(key)) {
              String deletedValue = valueArray[i];
              // 마지막 원소로 대체하고 size 감소
              keyArray[i] = keyArray[size - 1];
              valueArray[i] = valueArray[size - 1];
              keyArray[size - 1] = null;
              valueArray[size - 1] = null;
              size--;
              return deletedValue; // 삭제된 값을 반환
          }
      }
      return null; // 삭제할 키가 없으면 null 반환
  }

  @Override
  public int length() {
      return size; // 현재 저장된 쌍의 수 반환
  }
}

public class P0327_12 {
  public static void main(String[] args) {
      Dictionary1 dic = new Dictionary1(10); // Dictionary 객체 생성

      dic.put("황기태", "자바");
      dic.put("이재문", "파이선");
      dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정
      System.out.println("이재문의 값은 " + dic.get("이재문"));
      System.out.println("황기태의 값은 " + dic.get("황기태"));
      dic.delete("황기태"); // 황기태의 값을 삭제
      System.out.println("황기태의 값은 " + dic.get("황기태"));
  }
}
