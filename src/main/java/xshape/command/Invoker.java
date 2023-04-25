package xshape.command;

import java.util.Stack;

/*
 ? We may need to implement an observer on the Invoker's stacks so we can update the undo/redo buttons on change (Make them clickable or not)
 */

/*
 * Invoker class for the command pattern
 * Includes a singleton instance
*/
public class Invoker {
    private static Invoker instance;

    private Stack<ICommand> undoStack;
    private Stack<ICommand> redoStack;

    private Invoker() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public static Invoker getInstance() {
        if (instance == null) {
            instance = new Invoker();
        }
        return instance;
    }

    public void apply(ICommand command) {
        command.apply();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            ICommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            ICommand command = redoStack.pop();
            command.apply();
            undoStack.push(command);
        }
    }

    public String getStacksInfos() {
        StringBuffer stacksInfos = new StringBuffer();
        stacksInfos.append("Undo stack contains ");
        stacksInfos.append(undoStack.size());
        stacksInfos.append(" commands");
        stacksInfos.append("\nRedo stack contains ");
        stacksInfos.append(redoStack.size());
        stacksInfos.append(" commands");
        return stacksInfos.toString();
    }
}