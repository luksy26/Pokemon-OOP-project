# Text based Pokemon Battle Simulator with OOP

## Usage
For **IntelliJ**:
- Clone the repo and import the project
- Before running the code in `Main`, navigate to `Edit configurations` -> `arguments` :
   - `filename.txt` if you want to see the results in a file  
   - `null` if you want to see the results into the IDE console

## Design Patterns used:

- Builder: to easily create `Item`, `Pokemon` and `Ability` objects
- Singleton: for `PokemonFactory` and `ItemFactory` classes
- Factory: to create `Pokemon` and `Item` objects
- Command: for `Pokemon` class
