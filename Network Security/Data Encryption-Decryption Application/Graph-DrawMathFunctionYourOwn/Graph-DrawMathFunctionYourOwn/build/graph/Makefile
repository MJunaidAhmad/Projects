
SRC= Axis.java Graph2D.java ScanString.java \
     IsoCurve.java ScanWord.java Contour.java LoadData.java \
     SpecialFunction.java DataSet.java Markers.java TextLine.java \
     G2Dint.java ParseFunction.java BuildGraph.java RTextLine.java \
     VectorSet.java


comp:
	co $(SRC)
	javac -d ../classes $(SRC)
	rcsclean

docs:
	co -kv $(SRC)
	chmod u+w $(SRC)
	mv $(SRC) ..

dist:
	co $(SRC)

