# Zoo.java

Zoo.java is a simple Java program that simulates a zoo and allows users to interact with various animals. It provides a graphical user interface (GUI) using Java Swing, where users can perform actions such as adding animals, feeding them, and checking their status.

## Table of Contents

- [Customization](#customization)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Customization

To customize the images displayed for each animal, follow these steps:

1. Clone the repository to your local machine:

```bash
git clone https://github.com/YossiElgazari/Zoo.java.git
```

2. Change to the project directory:

```bash
cd Zoo.java
```

3. Open the `IDrawable.java` file located in the `src` folder.

4. Locate the following line of code:

```java
public final static String PICTURE_PATH = "path/to/image.png";
```

5. Replace `"path/to/image.png"` with the desired file path to your custom image for the animal. Make sure to use a valid file path, and ensure that the image file is accessible from the program's working directory.

6. Save the file after making the necessary changes.

## Usage

Once you have customized the image paths, you can run the `ZooFrame` program to interact with the zoo through the graphical user interface.

1. Compile the source code:

```bash
javac src/*.java
```

2. Run the program:

```bash
java src/ZooFrame
```

3. The GUI window will open, allowing you to add animals, feed them, and check their status using the provided buttons and input fields.

Feel free to explore the GUI and interact with the zoo!

## Contributing

If you'd like to contribute code, you can fork the repository and create a pull request with your changes. Please ensure that your code follows the existing style and conventions.
