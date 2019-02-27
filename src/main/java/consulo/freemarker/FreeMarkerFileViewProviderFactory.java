package consulo.freemarker;

import javax.annotation.Nonnull;

import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.FileViewProviderFactory;
import com.intellij.psi.PsiManager;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class FreeMarkerFileViewProviderFactory implements FileViewProviderFactory
{
	@Override
	public FileViewProvider createFileViewProvider(@Nonnull VirtualFile virtualFile, Language language, @Nonnull PsiManager psiManager, boolean b)
	{
		return new FreeMarkerFileViewProvider(psiManager, virtualFile, b);
	}
}
