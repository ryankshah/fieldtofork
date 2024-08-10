package com.ryankshah.fieldtofork;

import terrablender.api.TerraBlenderApi;

public class TerraBlenderSetup implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        FieldToForkCommon.setupTerraBlender();
    }
}