package xshape.command;

import java.util.ArrayList;
import java.util.Iterator;

public class CommandComposite implements ICommand, Iterable<ICommand> {

    private ArrayList<ICommand> _commands;

    public CommandComposite() {
        _commands = new ArrayList<ICommand>();
    }

    public void addCommand(ICommand command) {
        _commands.add(command);
    }

    public void removeCommand(ICommand command) {
        _commands.remove(command);
    }

    public void clearCommand() {
        _commands.clear();
    }

    @Override
    public void apply() {
        Iterator<ICommand> it = _commands.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
    }

    @Override
    public void undo() {
        Iterator<ICommand> it = _commands.iterator();
        while (it.hasNext()) {
            it.next().undo();
        }
    }

    @Override
    public Iterator<ICommand> iterator() {
        return _commands.iterator();
    }

}
