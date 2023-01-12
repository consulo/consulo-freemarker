package consulo.freemarker;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.file.FileViewProvider;
import consulo.language.file.VirtualFileViewProviderFactory;
import consulo.language.psi.PsiManager;
import consulo.virtualFileSystem.VirtualFile;
import consulo.virtualFileSystem.fileType.FileType;

import javax.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
@ExtensionImpl
public class FreeMarkerFileViewProviderFactory implements VirtualFileViewProviderFactory
{
	@Override
	public FileViewProvider createFileViewProvider(@Nonnull VirtualFile virtualFile, Language language, @Nonnull PsiManager psiManager, boolean b)
	{
		return new FreeMarkerFileViewProvider(psiManager, virtualFile, b);
	}

	@Nonnull
	@Override
	public FileType getFileType()
	{
		return FreeMarkerFileType.INSTANCE;
	}
}
