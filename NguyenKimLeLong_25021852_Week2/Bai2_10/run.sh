ROOT_DIR=$"pwd"
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java
java -cp "$BUILD_DIR" SmartLight