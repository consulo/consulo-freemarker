package consulo.freemarker;

import javax.annotation.Nonnull;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class FreeMarkerFileTypeFactory extends FileTypeFactory
{
	@Override
	public void createFileTypes(@Nonnull FileTypeConsumer fileTypeConsumer)
	{
		fileTypeConsumer.consume(FreeMarkerFileType.INSTANCE);
	}
}
