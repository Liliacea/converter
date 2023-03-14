# Converter
<h2>Реализация итератора итераторов </h2><br>
<h1> Тесты </h1><br>
<h3> hasNextNextSequentialInvocation </h3><br>
Последовательный вызов hasNext и Next. проверка работоспособночти <br>
<h3>testsThatNextMethodDoesntDependsOnPriorHasNextInvocation</h3><br>
Многократный вызов только Next возвращает следующее значение в итераторе и первое значение следующего итератора после завершения перебора предшествующего <br>
<h3>sequentialHasNextInvocationDoesntAffectRetrievalOrder</h3><br>
Порядок вызова hasNext и Next не имеет значения
<h3>hasNextShouldReturnFalseInCaseOfEmptyIterators</h3><br>
hasNext возвращает false в случае пустых итераторов
<h3>invocationOfNextMethodShouldThrowNoSuchElementException</h3><br>
next генерирует NoSuchElementException, когда заканчиваются элементы в последнем из перебираемых итераторе <br>
<h3>hasNextShouldReturnTheSameValuesInCaseOfMultiplyInvocation </h3><br>
Многократный вызов hasNext без вызова Next возвращает одно значение <br>
<h3>currentIteratorNotNull</h3><br>
currentIterator не может быть null <br>
<h3>moreIterators</h3><br>
Итератор работает корректно с любым количеством итераторов <br>
<h3>nextReturnTheSameValueIndependentlyTheMultiplyInvocationHasNext</h3><br>
Метод hasNext без вызова next не сдвигает указатель <br>
