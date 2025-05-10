package com.dreamfirestudios.lonelybluetradesmpplugin.DreamfireVariableTest;

import com.dreamfirestudios.dreamCore.DreamfirePersistentData.PersistentDataTypes;
import com.dreamfirestudios.dreamCore.DreamfireVariable.DreamfireVariableTest;
import com.dreamfirestudios.lonelybluetradesmpplugin.Enum.Messages;

import java.util.ArrayList;
import java.util.List;

public class LonelyBlueTradeSMPPluginMessagesVariableTest implements DreamfireVariableTest {
    @Override
    public PersistentDataTypes PersistentDataType() { return PersistentDataTypes.STRING; }

    @Override
    public boolean IsType(Object variable) {
        try{
            var test = Messages.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(Messages.class);
        data.add(Messages[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return Messages.valueOf(serializedData.toString());
    }

    @Override
    public Object ReturnDefaultValue() { return Messages.values()[0]; }

    @Override
    public List<String> TabData(List<String> list, String s) {
        var data = new ArrayList<String>();
        for(var x : Messages.values()) if(x.name().contains(s)) data.add(x.name());
        return data;
    }
}
