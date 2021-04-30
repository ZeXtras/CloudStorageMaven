package com.zextras.maven.s3storage;

import com.amazonaws.regions.AwsEnvVarOverrideRegionProvider;
import com.amazonaws.regions.AwsProfileRegionProvider;
import com.amazonaws.regions.AwsRegionProviderChain;
import com.amazonaws.regions.AwsSystemPropertyRegionProvider;
import com.amazonaws.regions.InstanceMetadataRegionProvider;

/**
 *
 */
public class S3StorageRegionProviderChain extends AwsRegionProviderChain {

    private final String providedRegion;

    /**
     * Creates a region provider chain based on the default AWS region provider chain.
     */
    public S3StorageRegionProviderChain() {
        this(null);
    }

    /**
     * Creates a region provider chain based on the default AWS region provider chain. The provided region may be null
     * if default behavior is desired.
     *
     * @param providedRegion Specific region to
     */
    public S3StorageRegionProviderChain(final String providedRegion) {
        super(new MavenSettingsRegionProvider(providedRegion),
          new AwsDefaultEnvRegionProvider(),
          new AwsEnvVarOverrideRegionProvider(),
          new AwsSystemPropertyRegionProvider(),
          new AwsProfileRegionProvider(),
          new InstanceMetadataRegionProvider());
        this.providedRegion = providedRegion;
    }

}
