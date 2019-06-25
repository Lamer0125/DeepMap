
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import java.util.List;
import java.util.ArrayList;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport;
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilter;
import com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysis;
import com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination;


public class StorageClassAnalysis {
	private static final Logger LOG = LoggerFactory.getLogger(StorageClassAnalysis.class);

	public static main() {
		try {
			final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
			String bucketName = "deepmap-pipeline-prod";
			String tagetBucketArn = "arn:aws:s3:::deepmap-anga";
			String prefix = "automation";
			AnalyticsConfiguration analyticsConfiguration = new AnalyticsConfiguration()
			.withStorageClassAnalysis(new StorageClassAnalysis()
				.withDataExport(new StorageClassAnalysisDataExport()
					.withDestination(new AnalyticsExportDestination()
						.withS3BucketDestination(new AnalyticsS3BucketDestination().withBucketArn(tagetBucketArn)
)))).withFilter(new AnalyticsFilter().withPredicate(new AnalyticsPrefixPredicate()))
			s3.setBucketAnalyticsConfiguration(bucketName, analyticsConfiguration)
		}
	}


}