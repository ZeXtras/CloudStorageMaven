package com.zextras.maven.s3storage;

import com.amazonaws.SdkClientException;
import com.amazonaws.regions.AwsRegionProvider;

public class AwsDefaultEnvRegionProvider extends AwsRegionProvider {

    public AwsDefaultEnvRegionProvider() {
    }

    @Override
    public String getRegion() throws SdkClientException {
        return System.getenv("AWS_DEFAULT_REGION");
    }
}
